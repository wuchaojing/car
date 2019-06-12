var user = JSON.parse(sessionStorage.getItem('user'))
if (!user) {
    location.href = 'index.html'
}
if (user.name != 'admin') {
    alert('非管理员,请使用管理员登录！')
    location.href = 'index.html'
}
function ajaxPost(url,data) {
    axios({
        method: 'post',
        url: url,
        data: data,
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(function (response) {
        var code = response.data.code
        var msg = response.data.msg
        if (code != 1) {
            alert(msg)
            if(msg == 'need login') {
                location.href = 'index.html'
            }
        } else {
            sessionStorage.setItem('comName','zuzhi')
            location.href = 'managerIndex.html'
        }
    })
}
var theFlag = 'manager'
var vm = new Vue({
    el: '#app',
    data: {
        flag: false,
        userName:user.name,
        newValue:'',
        newValue2:'',
        oldValue:'',
        comName: 'manager'
    },
    created: function() {
        this.comName = sessionStorage.getItem('comName') || 'manager'
    },
    methods:{
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
                        me.flag = false
                    }
                })
        },
        exit: function () {
            sessionStorage.removeItem('user')
            location.href = 'index.html'
        },
    },
    components: {
        zuzhi:{
            template: '#zuzhi',
            data:function(){
                return {
                    showFlag: true,
                    updateFlag1: false,
                    AddFlag1: false,
                    content:'',
                    addContent:'',
                    id:'',
                    msgFlag:'',
                    rank:'',
                    statement:'',
                    problemClassification:'',
                    auditHierarchy:'',
                    responsibleArea: '',
                }
            },
            methods: {
                show:function(){
                    this. showFlag = !this.showFlag
                },
                //ajax封装为一个方法
                anniuUpdate:function(){
                    this.updateFlag1 = !this.updateFlag1
                },
                anniuAdd:function(){
                    this.AddFlag1 = !this.AddFlag1
                },
                updateA:function(flag,name,id) {
                    this.msgFlag = flag
                    this.content = name;
                    this.id = id;
                    this.updateFlag1 = !this.updateFlag1
                },
                addA: function(flag){
                    this.msgFlag = flag
                    this.AddFlag1 = !this.AddFlag1
                },
                deleteA: function(flag,id) {
                    var a = window.confirm('确认删除?')
                    if (!a) {
                        return;
                    }
                    if(flag=='状态判断'){
                        var data = {
                            stateJudgementId: id
                        }
                        ajaxPost("http://localhost:8080/admin/state_judgement_delete",JSON.stringify(data))
                    }else if(flag == '等级') {
                        var data = {
                            rankId: id
                        }
                        ajaxPost('http://localhost:8080/admin/rank_delete',JSON.stringify(data))
                    }else if(flag == '审计层级') {
                        var data = {
                            auditHierarchyId: id
                        }
                        ajaxPost('http://localhost:8080/admin/audit_hierarchy_delete',JSON.stringify(data))
                    }else if(flag == '责任区域') {
                        var data = {
                            responsibleAreaId: id
                        }
                        ajaxPost('http://localhost:8080/admin/responsible_area_delete',JSON.stringify(data))
                    }else if(flag == '问题分类') {
                        var data = {
                            problemClassificationId: id
                        }
                        ajaxPost('http://localhost:8080/admin/problem_classification_delete',JSON.stringify(data))
                    }else if(flag == '细分类型') {
                        var data = {
                            stateJudgementId: id
                        }
                    }

                },
                sendUpdate: function() {
                    var a = window.confirm('确认修改?')
                    if (!a) {
                        return;
                    }
                    if(this.msgFlag=='状态判断'){
                        var data = {
                            stateJudgementName: this.content,
                            stateJudgementId: this.id
                        }
                        ajaxPost("http://localhost:8080/admin/state_judgement_update",JSON.stringify(data))
                    }else if(this.msgFlag == '等级') {
                        var data = {
                            rankName: this.content,
                            rankId: this.id
                        }
                        ajaxPost('http://localhost:8080/admin/rank_update',JSON.stringify(data))
                    }else if(this.msgFlag == '审计层级') {
                        var data = {
                            auditHierarchyName: this.content,
                            auditHierarchyId: this.id
                        }
                        ajaxPost('http://localhost:8080/admin/audit_hierarchy_update',JSON.stringify(data))
                    }else if(this.msgFlag == '责任区域') {
                        var data = {
                            responsibleAreaName: this.content,
                            responsibleAreaId: this.id
                        }
                        ajaxPost('http://localhost:8080/admin/responsible_area_update',JSON.stringify(data))
                    }else if(this.msgFlag == '问题分类') {
                        var data = {
                            problemClassificationName: this.content,
                            problemClassificationId: this.id
                        }
                        ajaxPost('http://localhost:8080/admin/problem_classification_update',JSON.stringify(data))
                    }else if(this.msgFlag == '细分类型') {

                    }


                },
                sendAdd:function() {
                    var a = window.confirm('确认添加?')
                    if (!a) {
                        return;
                    }

                    if(this.msgFlag=='状态判断'){
                        var data = {
                            stateJudgementName: this.addContent,
                        }
                        ajaxPost("http://localhost:8080/admin/state_judgement_insert",JSON.stringify(data))
                    }else if(this.msgFlag == '等级') {
                        var data = {
                            rankName: this.addContent,
                        }
                        ajaxPost('http://localhost:8080/admin/rank_insert',JSON.stringify(data))
                    }else if(this.msgFlag == '审计层级') {
                        var data = {
                            auditHierarchyName: this.addContent,
                        }
                        ajaxPost('http://localhost:8080/admin/audit_hierarchy_insert',JSON.stringify(data))
                    }else if(this.msgFlag == '责任区域') {
                        var data = {
                            responsibleAreaName: this.addContent,
                        }
                        ajaxPost('http://localhost:8080/admin/responsible_area_insert',JSON.stringify(data))
                    }else if(this.msgFlag == '问题分类') {
                        var data = {
                            problemClassificationName: this.addContent,
                        }
                        ajaxPost('http://localhost:8080/admin/problem_classification_insert',JSON.stringify(data))
                    }else if(this.msgFlag == '细分类型') {

                    }
                }
            },
            created: function() {
                var me = this;
                axios.get("http://localhost:8080/admin/state_judgement")
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            if (msg == 'need login') {
                                alert(msg)
                                location.href = 'index.html'
                            }
                        } else {
                            me.statement =  response.data.data
                        }
                    })
                axios.get("http://localhost:8080/admin/rank")
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            if (msg == 'need login') {
                                alert(msg)
                                location.href = 'index.html'
                            }
                        } else {
                            me.rank =  response.data.data
                        }
                    })
                axios.get("http://localhost:8080/admin/problem_classification")
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            if (msg == 'need login') {
                                alert(msg)
                                location.href = 'index.html'
                            }
                        } else {
                            me.problemClassification =  response.data.data
                        }
                    })
                axios.get("http://localhost:8080/admin/audit_hierarchy")
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            if (msg == 'need login') {
                                alert(msg)
                                location.href = 'index.html'
                            }
                        } else {
                            me.auditHierarchy =  response.data.data
                        }
                    })
                axios.get("http://localhost:8080/admin/responsible_area")
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            if (msg == 'need login') {
                                alert(msg)
                                location.href = 'index.html'
                            }
                        } else {
                            me.responsibleArea =  response.data.data
                        }
                    })
            }
        },
        manager:{
            template:'#manager',
            data:function() {
                return {
                    userAddflag:false,
                    msg:'',
                    position:'',
                    highName:'',
                    sname:'',
                    snumber:'',
                }
            },
            methods: {
                feiUser: function() {
                    this.userAddflag = !this.userAddflag
                },
                search: function () {
                    var position = []
                    var msg2 = {name: '无'}
                    position.push(msg2)
                    for (var i = 0; i < this.position.length; i++) {
                        if (this.position[i].name.indexOf(name) !== -1) {
                            var msg = {name: ''}
                            // console.log(this.position[i].name)
                            msg.name = this.position[i].name + '(' + this.position[i].number + ')'
                            position.push(msg)
                        }
                    }
                    return position
                },
                searchGo: function () {
                    var msg = []
                    for (var i = 0; i < this.msg.length; i++) {
                        if (this.msg[i].name.indexOf(this.sname) != -1 && this.msg[i].number.indexOf(this.snumber) != -1 ) {
                            msg.push(this.msg[i])
                        }
                    }
                    return msg
                },

                //删除操作
                del: function (id, index) {
                    var a = window.confirm('确认删除?')
                    if (!a) {
                        return;
                    }
                    var me = this
                    axios.post('http://localhost:8080/user/admin_delete?userId=' + id)
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                alert(msg)
                                if (msg == 'need login') {
                                    location.href = 'index.html'
                                }
                            } else {
                                me.msg.splice(index, 1)
                            }

                        })
                    sessionStorage.setItem('comName','manager')
                },
                //更新操作
                update: function (id, reviewState, msg) {
                    sessionStorage.setItem('comName','manager')
                    var a = window.confirm('确认更新?')
                    if (!a) {
                        return;
                    }
                    var suId
                    if (msg == '无') {
                        suId = ''
                    } else {
                        var start
                        for (var j = 0; j < msg.length; j++) {
                            if (msg[j] == '(') {
                                start = j
                                break;
                            }
                        }
                        var number = msg.slice(start + 1, msg.length - 1);
                        for (var i = 0; i < this.position.length; i++) {
                            if (this.position[i].number == number) {
                                suId = this.position[i].userId
                                break;
                            }
                        }
                    }
                    var data = {
                        userId: id,
                        reviewState: reviewState,
                        superiorId: suId
                    }
                    axios({
                            method: 'post',
                            url: 'http://localhost:8080/user/admin_update',
                            data: JSON.stringify(data),
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        }
                    )
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                alert(msg)
                                if (msg == 'need login') {
                                    location.href = 'index.html'
                                }
                            }
                            // else {
                            //     //直接删除这一行就行
                            //     alert('修改成功！')
                            // }
                        })

                }
            },
            created: function () {
                var me = this
                axios.get('http://localhost:8080/user/admin_search_all')
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.data
                        if (code != 1) {
                            alert('请先登录！')
                            location.href = 'index.html'
                            return;
                        } else {
                            axios.get('http://localhost:8080/user/register_superior')
                                .then(function (response) {
                                    var code = response.data.code
                                    var position = response.data.data
                                    if (code != 1) {
                                        alert(msg)
                                    } else {
                                        var flag
                                        me.position = position
                                        for (var i = 0; i < msg.length; i++) {
                                            flag = false
                                            for (var j = 0; j < me.position.length; j++) {
                                                if (flag) {
                                                    continue
                                                }
                                                if (msg[i].superiorId == me.position[j].userId) {
                                                    var msgAndNumber = me.position[j].name + '(' + me.position[j].number + ')'
                                                    msg[i].msgAndNumber = msgAndNumber
                                                    flag = true
                                                }
                                            }
                                        }
                                        for (var i = 0; i < msg.length; i++) {
                                            if (!msg[i].msgAndNumber) {
                                                msg[i].msgAndNumber = '无'
                                            }
                                        }
                                        me.msg = msg
                                    }

                                })
                        }
                    })
            }
        }
    }
})