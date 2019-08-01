var user = JSON.parse(sessionStorage.getItem('user'))
sessionStorage.removeItem('problemId')
if (!user) {
    location.href = 'index.html'
}
var vm = new Vue({
    el: '#app',
    data: {
        flag: false,
        newValue: '',
        newValue2: '',
        oldValue: '',
        userName: user.name,
        // msg2: '',
        msg: '',
        stateJudgement: '',
        problemClassification: '',
        subdivisionType: '',
        rank: '',
        auditHierarchy: '',
        repeatQuestion: '',
        completionStatus: '',
        startTime: '',
        endTime: '',
        responsibleArea: '',
        auditHierarchy: '',

        //下边的是ajax获取的信息
        stateJudgements: [],
        auditHierarchys: [],
        ranks: [],
        problemClassifications:[],
        ids:[],
        responsibleAreas:[],
        completionStatuses: [],
        leimsg: ''
    },
    methods: {
        edit(id) {
            sessionStorage.setItem('problemId',id)
            location.href = 'edit.html'
        },getTime: function () {
            if (this.startTime == '' && this.endTime == '') {
                return this.search()
            }
            var me = this
            var start = this.startTime + '+00:00:00'
            var end = this.endTime + '+23:59:59'
            axios.get('http://60.205.187.142:9090/safe_problem/search?startTime=' + start + '&endTime=' + end)
                .then(function (response) {
                    var code = response.data.code
                    var msg = response.data.msg
                    if (code != 1) {
                        alert(msg)
                        if (msg == 'need login') {
                            location.href = 'index.html'
                        }
                    } else {
                        var data = response.data.data
                        me.msg = data
                    }
                })
        },
        search: function () {
            var msg = []
            for (var i = 0; i < this.msg.length; i++) {
                var flag = true
                if(i==0) {
                    console.log(this.subdivisionType)
                    console.log(this.problemClassification)
                }
                if (this.msg[i].stateJudgement.indexOf(this.stateJudgement) != -1 && this.msg[i].problemClassification.indexOf(this.problemClassification) != -1 && this.msg[i].rank.indexOf(this.rank) != -1 && this.msg[i].auditHierarchy.indexOf(this.auditHierarchy) != -1 && this.msg[i].repeatQuestion.indexOf(this.repeatQuestion) != -1 &&this.msg[i].responsibleArea.indexOf(this.responsibleArea)!= -1) {
                    if (this.subdivisionType == '其他') {
                        for (var j = 0; j < this.leimsg.length - 1; j++) {
                            if (this.leimsg[j].indexOf(this.msg[i].subdivisionType) != -1) {
                                flag = false
                            }
                        }
                        if (this.completionStatus == '' && flag) {
                            var arr = this.msg[i].completionStatus.split('/')
                            if ((arr[0] == '完成') || (arr[0] == '已完成')) {
                                this.msg[i].status = 1
                            } else if (arr[0] == '未完成') {
                                this.msg[i].status = 0
                            } else {
                                if (!isNaN(parseInt(arr[0]))) {
                                    var c = parseInt(arr[0])
                                    var d = parseInt(arr[1])
                                    this.msg[i].status = parseInt(c / d)
                                }
                            }
                            msg.push(this.msg[i])
                        } else if (this.completionStatus == '完成' && flag) {
                            if (this.msg[i].status == 1) {
                                msg.push(this.msg[i])
                            }
                        } else {
                            if (this.msg[i].status == 0 && flag) {
                                msg.push(this.msg[i])
                            }
                        }
                    } else {
                        if(this.msg[i].subdivisionType===null) this.msg[i].subdivisionType=''
                        if (this.msg[i].subdivisionType.indexOf(this.subdivisionType) != -1) {
                            if (this.completionStatus == '') {
                                var arr = this.msg[i].completionStatus.split('/')
                                if ((arr[0] == '完成') || (arr[0] == '已完成')) {
                                    this.msg[i].status = 1
                                } else if (arr[0] == '未完成') {
                                    this.msg[i].status = 0
                                } else {
                                    if (!isNaN(parseInt(arr[0]))) {
                                        var c = parseInt(arr[0])
                                        var d = parseInt(arr[1])
                                        this.msg[i].status = parseInt(c / d)
                                    }
                                }
                                msg.push(this.msg[i])
                            } else if (this.completionStatus == '完成') {
                                if (this.msg[i].status == 1) {
                                    msg.push(this.msg[i])
                                }
                            } else {
                                if (this.msg[i].status == 0) {
                                    msg.push(this.msg[i])
                                }
                            }
                        }
                    }

                }
            }
            return msg
        },
        searchGo: function () {
            var id;
            var me = this;
            if(this.problemClassification == ''){
                this.subdivisionType = ''
                this.leimsg = ''
            }else {
                this.subdivisionType = ''
                for(var i=0;i<this.problemClassifications.length;i++) {
                    if(this.problemClassifications[i]==this.problemClassification){
                        id = this.ids[i]
                        break;
                    }
                }
                me.leimsg = []
                axios.get('http://60.205.187.142:9090/admin/subdivision_type?problemClassificationId='+id)
                    .then(function(response){
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            if (msg == 'need login') {
                                location.href = 'index.html'
                            }
                        } else {
                            var data = response.data.data
                            for(var i=0;i<data.length;i++)
                            {
                                me.leimsg.push(data[i].name)
                            }
                        }
                    })

            }

        },
        repass: function () {
            var me = this
            if (this.newValue != this.newValue2) {
                alert('确认密码和新密码不一致')
                return;
            }
            axios.post('http://60.205.187.142:9090/user/update_password?oldPassword=' + this.oldValue + '&newPassword=' + this.newValue)
                .then(function (response) {
                    var code = response.data.code
                    var msg = response.data.msg
                    if (code != 1) {
                        alert(msg)
                        if (msg == 'need login') {
                            location.href = 'index.html'
                        }
                    } else {
                        alert('修改成功')
                        me.flag = false
                    }
                })
        },
        exit: function () {
            sessionStorage.removeItem('user')
            axios.get('http://60.205.187.142:9090/user/logout')
                .then(function(response){
                    var code = response.data.code
                    location.href = 'index.html'
                })
        }
    },
    created: function () {
        var me = this
        var recordId = JSON.parse(sessionStorage.getItem('recordId'))
        var str = ""
        for(var i=0;i<recordId.length;i++) {
            str += '\''+recordId[i]+'\''
            if(i!=recordId.length-1) {
                str += ","
            }
        }
        console.log(str)
        axios.get('http://60.205.187.142:9090/record/safe_problems_batch?recordIds='+str)
            .then(function (response) {
                var code = response.data.code
                var msg = response.data.msg
                var data = response.data.data
                if (code != 1) {
                    alert(msg)
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    // sessionStorage.removeItem('recordId')
                    console.log(data)
                    me.msg = data
                }
            })
        var date = new Date()
        var year = date.getFullYear()
        var month = date.getMonth() + 1
        if (month == 1 ||month == 3 ||month == 5 ||month == 7) {
            this.startTime = year + '-0' + month + '-01'
            this.endTime = year + '-0' + month + '-31'
        }
        else if (month == 10 ||month == 12) {
            this.startTime = year + '-' + month + '-01'
            this.endTime = year + '-' + month + '-31'
        }
        else if (month == 2) {
            this.startTime = year + '-0' + month + '-01'
            this.endTime = year + '-0' + month + '-28'
        } else if (month == 11) {
            this.startTime = year + '-' + month + '-01'
            this.endTime = year + '-' + month + '-30'
        } else {
            this.startTime = year + '-0' + month + '-01'
            this.endTime = year + '-0' + month + '-30'
        }
        axios.get('http://60.205.187.142:9090/admin/state_judgement')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.stateJudgements.push(data[i].name)
                    }
                }
            })
        axios.get('http://60.205.187.142:9090/admin/rank')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.ranks.push(data[i].name)
                    }
                }
            })
        axios.get('http://60.205.187.142:9090/admin/problem_classification')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.problemClassifications.push(data[i].name)
                        me.ids.push(data[i].id)
                    }
                }
            })
        axios.get('http://60.205.187.142:9090/admin/responsible_area')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.responsibleAreas.push(data[i].name)
                    }
                }
            })
        axios.get('http://60.205.187.142:9090/admin/audit_hierarchy')
            .then(function(response){
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    for(var i=0;i<data.length;i++)
                    {
                        me.auditHierarchys.push(data[i].name)
                    }
                }
            })
    }
})