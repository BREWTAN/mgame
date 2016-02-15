var Dialog, FlatButton, FontAwesome, History, Loader, LoadingDiag, Login, Paper, PromiseState, RaisedButton, React, Router, TextField, connect, injectTapEventPlugin, linkState, ref, ref1, request;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Dialog = require('material-ui/lib/dialog');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

TextField = require('material-ui/lib/text-field');

Paper = require('material-ui/lib/paper');

Loader = require('halogen/RingLoader');

LoadingDiag = require("./loadingDiag.js");

FontAwesome = require('react-fontawesome');

ref = require('react-refetch'), connect = ref.connect, PromiseState = ref.PromiseState;

ref1 = require('react-router'), Router = ref1.Router, History = ref1.History;

request = require('superagent');

linkState = require('react-link-state');

Login = React.createClass({
  contextTypes: {
    router: React.PropTypes.object,
    history: React.PropTypes.object
  },
  getInitialState: function() {
    return {
      open: false,
      login_id: '',
      password: '',
      message: ''
    };
  },
  handleLoginCB: function(err, res) {
    console.log("LoginCB:" + JSON.stringify(res.body));
    if (res.body !== null && res.body.body.code === "0000") {
      console.log("login Success");
      this.context.history.pushState(null, "/ug");
    } else if (res.body === null) {
      this.setState({
        open: true,
        message: "登录失败:网络请求异常"
      });
    } else {
      this.setState({
        open: true,
        message: "登录失败:" + res.body.body.desc
      });
    }
  },
  handleOpen: function() {
    console.log("handleOpen::" + this.context.history);
    request.post('/orest/ssm/pbsin.do?fh=VSINSSM000000J00').send({
      login_id: this.state.login_id,
      password: this.state.password,
      op: '0',
      res_id: 'web'
    }).end(this.handleLoginCB);
  },
  handleClose: function() {
    console.log("handleClose::");
    this.setState({
      open: false
    });
  },
  render: function() {
    var actions, pstyle, style;
    console.log("render::login:message=" + this.state.message);
    actions = [
      React.createElement(FlatButton, {
        "label": "Cancel",
        "secondary": true,
        "onTouchTap": this.handleClose
      }), React.createElement(FlatButton, {
        "label": "Submit",
        "primary": true,
        "onTouchTap": this.handleClose
      })
    ];
    style = {
      margin: 12
    };
    pstyle = {
      margin: 0,
      textAlign: 'center'
    };
    return React.createElement("div", {
      "className": "container-fluid"
    }, React.createElement("div", {
      "className": "login-mm "
    }, React.createElement("div", {
      "className": "container pull-left"
    }, React.createElement("img", {
      "src": 'images/mm0.png'
    }))), React.createElement("div", {
      "className": "container login-bg pull-right"
    }, React.createElement("div", {
      "className": "container-fluid login-diag"
    }, React.createElement(Paper, {
      "style": pstyle,
      "zDepth": 1.
    }, React.createElement("div", {
      "className": "login-msg"
    }), React.createElement("div", {
      "className": "login-title"
    }, "请登录"), React.createElement("form", {
      "className": "form-horizontal"
    }, React.createElement("div", {
      "className": "row"
    }, React.createElement(TextField, {
      "hintText": "Email/UserID",
      "floatingLabelText": "请输入邮箱或者用户名",
      "valueLink": linkState(this, 'login_id')
    })), React.createElement("div", {
      "className": "row"
    }, React.createElement(TextField, {
      "type": "password",
      "hintText": "Password",
      "floatingLabelText": "请输入密码",
      "valueLink": linkState(this, 'password')
    })), React.createElement("div", {
      "className": "clearfix"
    }), React.createElement("div", {
      "className": "row"
    }, React.createElement("div", {
      "className": "col-md-4 "
    }, "忘记密码?"), React.createElement("div", {
      "className": "col-md-4"
    }), React.createElement("div", {
      "className": "col-md-4"
    }, "重置")), React.createElement("div", {
      "className": ""
    }, React.createElement(RaisedButton, {
      "label": "立即登录",
      "icon": React.createElement(FontAwesome, {
        "name": 'sign-in',
        "className": 'fa-lg fa-inverse'
      }),
      "primary": true,
      "style": style,
      "onTouchTap": this.handleOpen
    })))), React.createElement(LoadingDiag, {
      "open": this.state.open,
      "message": this.state.message,
      "handleDiagClose": this.handleClose
    }))));
  }
});

module.exports = Login;

injectTapEventPlugin();
