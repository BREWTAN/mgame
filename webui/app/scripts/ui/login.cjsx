React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

Dialog = require('material-ui/lib/dialog');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
TextField = require('material-ui/lib/text-field');
Paper = require( 'material-ui/lib/paper');

{ connect, PromiseState } = require( 'react-refetch');
{ Router } =require( 'react-router')


Login = React.createClass(

    contextTypes: {
        router: React.PropTypes.object
    },

    getInitialState:() ->
        open: false

    handleOpen :()  ->
        console.log("handleOpen::"+@context.router);
        #@props.onLoginSuccess("abc")
        @context.router.replace("comment")

        console.log("handleOpen:oookk");

        #@setState open: true
        return


    handleClose : ()  ->
        console.log("handleClose::");
        #@setState open: false
        return


    render:() ->
        console.log("render::login.cs")
        actions = [
            <FlatButton
                label="Cancel"
                secondary={true}
                onTouchTap={this.handleClose}
            />,
            <FlatButton
                label="Submit"
                primary={true}
                onTouchTap={this.handleClose}
            />,
        ];

        style = {
            margin: 12,
        };
        pstyle={
            height: '100%',
            width: '100%',
            margin: 0,
            textAlign: 'center',
            display: 'inline-block',
        }
        return (
            <div>
                <Paper style={pstyle} zDepth={1}>
                    <form className="form-horizontal">
                        <div className="row">
                            <TextField
                                hintText="Email/UserID"
                                floatingLabelText="请输入邮箱或者用户名"
                            />
                        </div>
                        <div className="row">
                            <TextField
                                type="password"
                                hintText="Password"
                                floatingLabelText="请输入密码"  />
                        </div>
                        <div className="clearfix">
                        </div>
                        <div className="row">
                            <div className="col-lg-6"  >
                                <RaisedButton label="登录" secondary={true} style={style} onTouchTap={this.handleOpen}/>
                            </div >
                            <div className="col-lg-6">
                                <RaisedButton label="注册" style={style} />
                            </div>
                        </div>
                    </form>
                </Paper>
            </div>
        )

)

module.exports = Login
injectTapEventPlugin();

