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
        msg2: '',
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
        },
        searchGo: function () {
            var id;
            var me = this;
            if(this.problemClassification == ''){
                this.subdivisionType = ''
                this.leimsg = ''
            }else {
                for(var i=0;i<this.problemClassifications.length;i++) {
                    if(this.problemClassifications[i]==this.problemClassification){
                        id = this.ids[i]
                        break;
                    }
                }
                me.leimsg = []
                axios.get('http://localhost:8080/admin/subdivision_type?problemClassificationId='+id)
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
            axios.post('http://localhost:8080/user/update_password?oldPassword=' + this.oldValue + '&newPassword=' + this.newValue)
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
            location.href = 'index.html'
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
        axios.get('http://localhost:8080/record/safe_problems_batch?recordIds='+str)
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
                    me.msg2 = data
                }
            })
        var me = this
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
        axios.get('http://localhost:8080/safe_problem/search_this_month')
            .then(function (response) {
                var code = response.data.code
                var msg = response.data.msg
                if (code != 1) {
                    if (msg == 'need login') {
                        location.href = 'index.html'
                    }
                } else {
                    var data = response.data.data
                    me.msg = data
                }
            })
        axios.get('http://localhost:8080/admin/state_judgement')
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
        axios.get('http://localhost:8080/admin/rank')
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
        axios.get('http://localhost:8080/admin/problem_classification')
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
        axios.get('http://localhost:8080/admin/responsible_area')
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
        axios.get('http://localhost:8080/admin/audit_hierarchy')
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