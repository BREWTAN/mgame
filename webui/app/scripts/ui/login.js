var Dialog, FlatButton, History, Loader, LoadingDiag, Login, Paper, PromiseState, RaisedButton, React, Router, TextField, connect, injectTapEventPlugin, linkState, ref, ref1, request;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Dialog = require('material-ui/lib/dialog');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

TextField = require('material-ui/lib/text-field');

Paper = require('material-ui/lib/paper');

Loader = require('halogen/RingLoader');

LoadingDiag = require("./loadingDiag.js");

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
    if (res.body.body.code === "0000") {
      console.log("login Success");
      this.context.history.pushState(null, "/comment");
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
      height: '100%',
      width: '100%',
      margin: 0,
      textAlign: 'center',
      display: 'inline-block'
    };
    return React.createElement("div", null, React.createElement(Paper, {
      "style": pstyle,
      "zDepth": 1.
    }, React.createElement("form", {
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
      "className": "col-lg-6"
    }, React.createElement(RaisedButton, {
      "label": "登录",
      "secondary": true,
      "style": style,
      "onTouchTap": this.handleOpen
    })), React.createElement("div", {
      "className": "col-lg-6"
    }, React.createElement(RaisedButton, {
      "label": "注册",
      "style": style
    }))))), React.createElement(LoadingDiag, {
      "open": this.state.open,
      "message": this.state.message,
      "handleDiagClose": this.handleClose
    }));
  }
});

module.exports = Login;

injectTapEventPlugin();
