var Dialog, FlatButton, RaisedButton, React, injectTapEventPlugin, login;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Dialog = require('material-ui/lib/dialog');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

login = React.createClass({
  getInitialState: function() {
    return {
      open: false
    };
  },
  handleOpen: function() {
    console.log("handleOpen::");
    this.setState({
      open: true
    });
  },
  handleClose: function() {
    console.log("handleClose::");
    this.setState({
      open: false
    });
  },
  render: function() {
    var actions;
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
    console.log("render::");
    return React.createElement("div", null, React.createElement(RaisedButton, {
      "label": "Modal Dialog",
      "onTouchTap": this.handleOpen
    }), React.createElement(Dialog, {
      "title": "Dialog With Actions",
      "actions": actions,
      "modal": false,
      "open": this.state.open,
      "onRequestClose": this.handleClose
    }, "Only actions can close this dialog."));
  }
});

module.exports = login;

injectTapEventPlugin();
