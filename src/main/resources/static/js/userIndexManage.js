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
            axios.get('http://localhost:8080/user/logout')
                .then(function(response){
                    var code = response.data.code
                    location.href = 'index.html'
                })
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
                    file:'',
                    date:''
                }
            },
            methods:{
                upload: function (event) {
                    this.file = event.target.files[0]
                },
                submit: function (event) {
                    var me = this

                    var date = this.date.split('/').join('-')
                    var formdata = new FormData();
                    formdata.append('file', me.file);
                    formdata.append('secondCategoryId', me.secondWriteCategory);
                    formdata.append('happenTime',date)
                    console.log(me.file)
                    console.log(me.secondWriteCategory)
                    console.log(me.date)
                    if(!me.file||!me.secondWriteCategory||!me.date){
                        alert('必须完整输入才可以！')
                        return false
                    }
                    me.buttonFlag = false
                    var config = {
                        headers: {
                            'Content-Type': 'multipart/form-data'  //之前说的以表单传数据的格式来传递fromdata
                        }
                    };
                    axios.post('http://localhost:8080/doc/upload', formdata, config)
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
                    axios.get('http://localhost:8080/doc/get_secondCategory?categoryId='+me.writeCategory)
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
                axios.get('http://localhost:8080/doc/get_category')
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
                    axios.get('http://localhost:8080/doc/get_secondCategory?categoryId='+me.writeCategory)
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
                    axios.get('http://localhost:8080/doc/get_doc?secondCategoryId='+me.secondWriteCategory)
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
                    axios.get('http://localhost:8080/doc/delete_doc?docId='+id)
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
                axios.get('http://localhost:8080/doc/get_category')
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
                    password2:'',
                    level:'',
                    detail:''
                }
            },
            methods: {
                del:function(id,index){
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
                feiUser: function() {
                    this.userAddflag = !this.userAddflag
                },
                sendMsg: function () {
                    var id = ''
                    var user = JSON.parse(sessionStorage.getItem('user'))
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
                    var data = {name: this.name, password: this.password, number: this.number, level:this.level,detail:this.detail,superiorId:id}

                    axios({
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
                var user = JSON.parse(sessionStorage.getItem('user'))
                var level = user.level
                if(user.level=='车间长') {
                    this.level = '工段长'
                }else if(user.level=='工段长') {
                    this.level = '班组长'
                }
                var me = this
                axios.get('http://localhost:8080/user/user_search_part')
                    .then(function (response) {
                        var code = response.data.code
                        var msg = response.data.data
                        if (code != 1) {
                            alert(msg)
                            if (msg == 'need login') {
                                location.href = 'index.html'
                            }
                        } else {
                            me.msg = msg
                        }

                    });
                /*axios.get('http://localhost:8080/user/register_superior')
                    .then(function (response) {
                        var code = response.data.code
                        var position = response.data.data
                        if (code != 1) {
                            alert(msg)
                            if (msg == 'need login') {
                                location.href = 'index.html'
                            }
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

                    })*/
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
                    axios.post('http://localhost:8080/safe_problem/upload', formdata, config)
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
                    axios.get('http://localhost:8080/record/safe_problems_batch?recordIds='+str)
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
                    axios.get('http://localhost:8080/record/safe_problems?recordId=' + id)
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
        },
        jifenManage:{
            template:'#jifenManage',
            data: function(){
                return {
                    id:'',
                    name: '',
                    mark:'',
                    reason:'',
                    reasons:'',
                    level: '',
                    flag: true
                }
            },
            methods:{
                change(id){
                    for(var i=0;i<this.level.length;i++){
                        if(id==this.level[i].userId){
                            this.name = this.level[i].name
                            break;
                        }
                    }
                },
                send:function(){
                    var user = JSON.parse(sessionStorage.getItem('user'))
                    if(isNaN(this.mark)){
                        alert('积分必须是数字形式！例如+5，-3，5')
                        return
                    }
                    var data = {
                        name: this.name,
                        reason: this.reason,
                        mark: this.mark,
                        userId: this.id,
                        markId: user.userId,
                        level: user.level
                    }
                    axios({
                        method:'post',
                        url:'http://localhost:8080/user/mark',
                        data: JSON.stringify(data),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(function(response){
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            alert(msg)
                            if (msg == 'need login') {
                                location.href = 'index.html'
                            }
                        } else {
                            location.href = 'userIndexManage.html'
                        }
                    })
                }
            },
            created:function(){
                var user = JSON.parse(sessionStorage.getItem('user'))
                var me = this
                if(user.level!='班组长') {
                    me.flag = false
                    axios.get('http://localhost:8080/user/direct_sons?userId='+user.userId)
                        .then(function(response){
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                alert(msg)
                                if (msg == 'need login') {
                                    location.href = 'index.html'
                                }
                            } else {
                                var data = response.data.data
                                me.level = data
                            }
                        })
                    }
                    axios.get('http://localhost:8080/admin/reason')
                        .then(function(response){
                            var code = response.data.code
                            var msg = response.data.msg
                            if (code != 1) {
                                alert(msg)
                                if (msg == 'need login') {
                                    location.href = 'index.html'
                                }
                            } else {
                                var data = response.data.data
                                me.reasons = data
                            }
                        })
                }

        },
        jifenWatch:{
            template:'#jifenWatch',
            data:function(){
                return {
                    msg:'',
                    myMsg:[],
                    sname:''
                }
            },
            methods:{
                del: function(id) {
                    var a = window.confirm('确认删除?')
                    if (!a) {
                        return;
                    }
                    var data = {
                        markId: id
                    }
                    axios({
                        method:'post',
                        url:'http://localhost:8080/user/mark_delete',
                        data:JSON.stringify(data),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(function(response){
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            alert(msg)
                            if (msg == 'need login') {
                                location.href = 'index.html'
                            }
                        } else {
                            location.href = 'userIndexManage.html'
                        }
                    })
                },
                search:function(){
                    var msg = []
                    for(var i=0;i<this.msg.length;i++){
                        console.log(this.msg[i])
                        if(this.msg[i].name.indexOf(this.sname)!==-1){
                            msg.push(this.msg[i])
                        }
                    }
                    return msg
                }
            },
            created:function(){
                var user = JSON.parse(sessionStorage.getItem('user'))
                var id = user.userId
                var me = this
                axios.get('http://localhost:8080/user/self_and_sons_mark?userId='+id)
                    .then(function(response){
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
                            for(var i=0;i<me.msg.length;i++){
                                if(me.msg[i].userId==id)
                                {
                                    me.myMsg.push(me.msg[i])
                                    me.msg.splice(i,1)
                                    i--;
                                }
                            }
                        }
                    })
            }
        },
        zongjiFen:{
            template:'#zongjiFen',
            data:function(){
                return {
                    msg:'',
                    myMsg:'',
                    sname:''
                }
            },
            methods:{
                del: function(id) {
                    var a = window.confirm('确认删除?')
                    if (!a) {
                        return;
                    }
                    var data = {
                        markId: id
                    }
                    axios({
                        method:'post',
                        url:'http://localhost:8080/user/mark_delete',
                        data:JSON.stringify(data),
                        headers: {
                            'Content-Type': 'application/json'
                        }
                    }).then(function(response){
                        var code = response.data.code
                        var msg = response.data.msg
                        if (code != 1) {
                            alert(msg)
                            if (msg == 'need login') {
                                location.href = 'index.html'
                            }
                        } else {
                            location.href = 'userIndexManage.html'
                        }
                    })
                },
                search:function(){
                    var msg = []
                    for(var i=0;i<this.msg.length;i++){
                        if(this.msg[i].name.indexOf(this.sname)!==-1){
                            msg.push(this.msg[i])
                        }
                    }
                    return msg
                }
            },
            created:function(){
                var user = JSON.parse(sessionStorage.getItem('user'))
                var id = user.userId
                var me = this
                axios.get('http://localhost:8080/user/self_and_sons_mark_sum?userId='+id)
                    .then(function(response){
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
                            for(var i=0;i<me.msg.length;i++){
                                if(me.msg[i].userId==id)
                                {
                                    me.myMsg = me.msg[i]
                                    console.log(me.myMsg)
                                    me.msg.splice(i,1)
                                    break;
                                }
                            }
                        }
                    })
            }
        },
    },
    created: function () {
        var me = this
        axios.get('http://localhost:8080/record/relative_records')
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
