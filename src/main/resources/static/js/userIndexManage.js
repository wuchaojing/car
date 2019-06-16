var user = JSON.parse(sessionStorage.getItem('user'))

if (!user || (user.name == 'audit') || (user.name == 'admin')) {
    location.href = 'index.html'
}
var vm = new Vue({
    el: '#app',
    data: {
        compName: 'userManage',
        flag: false,
        newValue: '',
        newValue2: '',
        oldValue: '',
        userName: user.name,
        submits: '',
        file: '',
    },
    methods: {
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
            location.href = 'index.html'
        }
    },
    components: {
        fileUpload:{
            template: '#fileUpload',
            data:function(){
                return {
                    buttonFlag:true,
                    category:'',
                    secondCategory:'',
                    writeCategory:'',
                    secondWriteCategory:'',
                    doc:'',
                    file:''
                }
            },
            methods:{
                upload: function (event) {
                    this.file = event.target.files[0]
                },
                submit: function (event) {
                    var me = this
                    me.buttonFlag = false
                    var formdata = new FormData();
                    formdata.append('file', me.file);
                    formdata.append('secondCategoryId', me.secondWriteCategory);
                    var config = {
                        headers: {
                            'Content-Type': 'multipart/form-data'  //之前说的以表单传数据的格式来传递fromdata
                        }
                    };
                    axios.post('http://60.205.187.142:9090/doc/upload', formdata, config)
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                alert(msg)
                                if (msg == 'need login') {
                                    location.href = 'index.html'
                                }
                                location.href = 'userIndex.html'
                            } else {
                                alert('上传成功!')
                                location.href = 'userIndexManage.html'
                            }
                        })
                },
                searchSecond:function(){
                    var me = this;
                    axios.get('http://60.205.187.142:9090/doc/get_secondCategory?categoryId='+me.writeCategory)
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                if (msg == 'need login') {
                                    alert(msg)
                                    location.href = 'index.html'
                                }
                            } else {
                                me.secondCategory =  response.data.data
                            }
                        })
                },
            },
            created: function() {
                var me = this;
                axios.get('http://60.205.187.142:9090/doc/get_category')
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            if (msg == 'need login') {
                                alert(msg)
                                location.href = 'index.html'
                            }
                        } else {
                            me.category =  response.data.data
                        }
                    })

            }
        },
        fileWatch:{
            template: '#fileWatch',
            data:function(){
                return {
                    category:'',
                    secondCategory:'',
                    writeCategory:'',
                    secondWriteCategory:'',
                    doc: ''
                }
            },
            methods:{
                searchSecond:function(){
                    var me = this;
                    axios.get('http://60.205.187.142:9090/doc/get_secondCategory?categoryId='+me.writeCategory)
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                if (msg == 'need login') {
                                    alert(msg)
                                    location.href = 'index.html'
                                }
                            } else {
                                me.secondCategory =  response.data.data
                            }
                        })
                },
                seeDoc: function() {
                    var me = this
                    axios.get('http://60.205.187.142:9090/doc/get_doc?secondCategoryId='+me.secondWriteCategory)
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                if (msg == 'need login') {
                                    alert(msg)
                                    location.href = 'index.html'
                                }
                            } else {
                                me.doc =  response.data.data
                                console.log(me.doc)
                            }
                        })
                },
                deleteDoc:function(id) {
                    var me = this
                    axios.get('http://60.205.187.142:9090/doc/delete_doc?docId='+id)
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                if (msg == 'need login') {
                                    alert(msg)
                                    location.href = 'index.html'
                                }
                            } else {
                                location.href = 'userIndexManage.html'
                            }
                        })
                }
            },
            created: function() {
                var me = this;
                axios.get('http://60.205.187.142:9090/doc/get_category')
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            if (msg == 'need login') {
                                alert(msg)
                                location.href = 'index.html'
                            }
                        } else {
                            me.category =  response.data.data
                        }
                    })

            }
        },
        userManage:{
            template:'#userManage',
            data:function(){
                return {
                    msg: '',
                    position: '',
                    userAddflag: false,
                    username: '',
                    number: '',
                    name:'',
                    password:'',
                    password2:''
                }
            },
            methods: {
                feiUser: function() {
                    this.userAddflag = !this.userAddflag
                },
                sendMsg: function () {
                    var id = ''
                    if (this.password != this.password2) {
                        alert('两次密码不一致')
                        return;
                    } else if (this.number == 'admin' || this.number == 'audit') {
                        alert('此编号不可注册!')
                        return;
                    }
                    else {
                        id = user.userId
                    }
                    if (id === undefined) {
                        alert('没有此上级!')
                        return;
                    }
                    var data = {name: this.name, password: this.password, number: this.number, superiorId: id}
                    axios({
                        method: 'post',
                        url: 'http://60.205.187.142:9090/user/register',
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
                            alert('注册成功')
                            location.href = 'userIndexManage.html'
                        }
                    })
                }

            },
            created: function () {
                var me = this
                axios.get('http://60.205.187.142:9090/user/user_search_part')
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.data
                        if (code != 1) {
                            alert('请先登录！')
                            location.href = 'index.html'
                            return;
                        } else {
                            axios.get('http://60.205.187.142:9090/user/register_superior')
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

                    });
            }
        },
        upload: {
            template: '#upload',
            data: function () {
                return {
                    buttonFlag: true
                }
            },
            methods: {
                upload: function (event) {
                    this.file = event.target.files[0]
                },
                submit: function (event) {
                    var me = this
                    me.buttonFlag = false
                    var formdata = new FormData();
                    formdata.append('myFiles', this.file);
                    var config = {
                        headers: {
                            'Content-Type': 'multipart/form-data'  //之前说的以表单传数据的格式来传递fromdata
                        }
                    };
                    axios.post('http://60.205.187.142:9090/safe_problem/upload', formdata, config)
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                alert(msg)
                                if (msg == 'need login') {
                                    location.href = 'index.html'
                                }
                                location.href = 'userIndexManage.html'
                            } else {
                                alert('上传成功!')
                                location.href = 'userIndexManage.html'
                            }
                        })
                }


            }
        },
        submitRecodes: {
            template: '#submitRecodes',
            data: function () {
                return {
                    records:[]
                }
            },
            methods: {
                searchRecords:function() {
                    var me = this
                    var str = ""
                    for(var i=0;i<this.records.length;i++) {
                        str += '\''+this.records[i]+'\''
                        if(i!=this.records.length-1) {
                            str += ","
                        }
                    }
                    axios.get('http://60.205.187.142:9090/record/safe_problems_batch?recordIds='+str)
                        .then(function(response){
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                alert(msg)
                                if (msg == 'need login') {
                                    location.href = 'index.html'
                                }
                            } else {
                                sessionStorage.setItem('recordId', JSON.stringify(me.records))
                                location.href = 'detail.html'
                            }
                        })
                },
                checks: function(event){
                    var checked = event.target.checked
                    var value = event.target.value
                    if(checked) {
                        this.records.push(value)
                    }else {
                        for(var i=0;i<this.records.length;i++) {
                            if(this.records[i]==value){
                                this.records.splice(i,1)
                                break;
                            }
                        }
                    }
                },
                /*go: function (id) {
                    axios.get('http://60.205.187.142:9090/record/safe_problems?recordId=' + id)
                        .then(function (response) {
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                alert(msg)
                                if (msg == 'need login') {
                                    location.href = 'index.html'
                                }
                            } else {
                                sessionStorage.setItem('recordId', JSON.stringify(id))
                                location.href = 'detail.html'
                            }
                        })
                }*/
            },
            props: ['submits']
        }
    },
    created: function () {
        var me = this
        axios.get('http://60.205.187.142:9090/record/relative_records')
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
                    me.submits = data
                }
            })
    }
});
