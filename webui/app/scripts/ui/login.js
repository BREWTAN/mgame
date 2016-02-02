var Dialog, FlatButton, Login, Paper, PromiseState, RaisedButton, React, Router, TextField, connect, injectTapEventPlugin, ref;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Dialog = require('material-ui/lib/dialog');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

TextField = require('material-ui/lib/text-field');

Paper = require('material-ui/lib/paper');

ref = require('react-refetch'), connect = ref.connect, PromiseState = ref.PromiseState;

Router = require('react-router').Router;

Login = React.createClass({
  contextTypes: {
    router: React.PropTypes.object
  },
  getInitialState: function() {
    return {
      open: false
    };
  },
  handleOpen: function() {
    console.log("handleOpen::" + this.context.router);
    this.context.router.replace("comment");
    console.log("handleOpen:oookk");
  },
  handleClose: function() {
    console.log("handleClose::");
  },
  render: function() {
    var actions, pstyle, style;
    console.log("render::login.cs");
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
      "floatingLabelText": "请输入邮箱或者用户名"
    })), React.createElement("div", {
      "className": "row"
    }, React.createElement(TextField, {
      "type": "password",
      "hintText": "Password",
      "floatingLabelText": "请输入密码"
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
    }))))));
  }
});

module.exports = Login;

injectTapEventPlugin();
