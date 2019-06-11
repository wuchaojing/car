var user = JSON.parse(sessionStorage.getItem('user'))
if (!user) {
    location.href = 'index.html'
}
if (user.name != 'admin') {
    alert('非管理员,请使用管理员登录！')
    location.href = 'index.html'
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
        this.comName = theFlag
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
                    updateFlag: false,
                    content:'',
                    statement:'',
                    id:'',
                }
            },
            methods: {
                anniu:function(){
                    this.updateFlag = !this.updateFlag
                },
                updateA:function(name,id) {
                    this.content = name;
                    this.id = id;
                    this.updateFlag = !this.updateFlag
                },
                sendA: function() {
                    var a = window.confirm('确认修改?')
                    if (!a) {
                        return;
                    }
                    var data = {
                        stateJudgementName: this.content,
                        stateJudgementId: this.id
                    }
                    console.log(data)
                    axios({
                        method: 'post',
                        url: 'http://localhost:8080/admin/state_judgement_update',
                        data: JSON.stringify(data),
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
                            theFlag = 'zuzhi'
                            location.href = 'managerIndex.html'
                        }
                    })
                }
            },
            created: function() {
                var me = this;
                var me = this
                axios.get('http://localhost:8080/admin/state_judgement')
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            if (msg == 'need login') {
                                alert(msg)
                                location.href = 'index.html'
                            }
                        } else {
                            me.statement = response.data.data
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
                },
                //更新操作
                update: function (id, reviewState, msg) {
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