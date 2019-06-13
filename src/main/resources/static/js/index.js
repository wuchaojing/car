//组件
sessionStorage.removeItem('user')
sessionStorage.removeItem('recordId')
Vue.prototype.$axios = axios;
var vm = new Vue({
    el: '#app',
    data: {
        compName: 'login',
        flag: true
    },
    methods: {},
    components: {
        login: {
            template: '#login',
            data: function () {
                return {
                    username: '',
                    password: '',
                }
            },
            methods: {
                //添加active类效果
                getMsg: function () {
                    this.$axios.get('http://localhost:8080/user/login?number=' + this.username + '&password=' + this.password)
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            var data = response.data.data
                            if (code != 1) {
                                alert(msg)
                            } else {
                                sessionStorage.setItem('user', JSON.stringify(data))
                                if (data.name == 'admin')
                                    location.href = 'managerIndex.html'
                                else if (data.name == 'audit') {
                                    location.href = 'pageView.html'
                                } else {
                                    location.href = 'userIndexManage.html'
                                }
                            }
                        })
                }
            }

        },
        register: {
            template: '#register',
            data: function () {
                return {
                    flag: false,
                    higherName: '',
                    name: '',
                    password: '',
                    password2: '',
                    number: '',
                    position: [],
                }
            },
            created: function () {
                var me = this;
                this.$axios.get('http://localhost:8080/user/register_superior')
                    .then(function (response) {
                        // console.log(1)
                        var code = response.data.code
                        var msg = response.data.data
                        if (code != 1) {
                            alert(msg)
                        } else {
                            me.position = msg
                        }
                    })
            },
            methods: {
                show: function () {
                    this.flag = true
                },
                hide: function () {
                    this.flag = false
                },
                showIn: function (name) {
                    this.flag = false
                    this.higherName = name
                },
                search: function (name) {
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
                sendMsg: function () {
                    var id
                    console.log(this.number)
                    if (this.password != this.password2) {
                        alert('两次密码不一致')
                        return;
                    } else if (this.number == 'admin' || this.number == 'audit') {
                        alert('此编号不可注册!')
                        return;
                    }
                    else {
                        if (this.higherName == '无') {
                            id = ''
                        } else {
                            var start
                            for (var j = 0; j < this.higherName.length; j++) {
                                if (this.higherName[j] == '(') {
                                    start = j
                                    break;
                                }
                            }
                            var number = this.higherName.slice(start + 1, this.higherName.length - 1);
                            for (var i = 0; i < this.position.length; i++) {
                                if (this.position[i].number == number) {
                                    id = this.position[i].userId
                                    break;
                                }
                            }
                        }
                        if (id === undefined) {
                            alert('没有此上级!')
                            return;
                        }
                        var data = {name: this.name, password: this.password, number: this.number, superiorId: id}
                        this.$axios({
                            method: 'post',
                            url: 'http://localhost:8080/user/register',
                            data: JSON.stringify(data),
                            headers: {
                                'Content-Type': 'application/json'
                            }
                        }).then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                alert(msg)
                            } else {
                                alert('注册成功')
                                location.href = 'index.html'
                            }
                        })
                    }


                }
            }
        }
    }
});
