React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

Dialog = require('material-ui/lib/dialog');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');
TextField = require('material-ui/lib/text-field');
Paper = require( 'material-ui/lib/paper');
Loader = require('halogen/RingLoader');
LoadingDiag = require("./loadingDiag.js")

{ connect, PromiseState } = require( 'react-refetch');
{ Router,History } =require( 'react-router')
request = require('superagent');
linkState = require('react-link-state')

Login = React.createClass(

    contextTypes: {
        router: React.PropTypes.object
        history:　React.PropTypes.object
    },

    getInitialState:() ->
        open: false
        login_id: '',
        password: '',
        message: ''

    handleLoginCB:(err,res) ->
        console.log("LoginCB:"+JSON.stringify(res.body))
        #router.push("comment")
        if res.body.body.code=="0000"
            console.log("login Success")
            @context.history.pushState(null,"/comment")
        else
            @setState
                open:true
                message:"登录失败:"+res.body.body.desc
        return

    handleOpen :()  ->
        console.log("handleOpen::"+@context.history);
        #@props.onLoginSuccess("abc")

        #@setState({open:true})
        request.post('/orest/ssm/pbsin.do?fh=VSINSSM000000J00')
           .send({ login_id: @state.login_id, password: @state.password, op: '0', res_id: 'web' })
           .end(@handleLoginCB);
　
        #@setState open: true
        return


    handleClose : ()  ->
        console.log("handleClose::");
        @setState open: false
        return


    render:() ->
        console.log("render::login:message="+@state.message)
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
                                floatingLabelText="请输入邮箱或者用户名" valueLink={linkState(this,'login_id')}
                            />
                        </div>
                        <div className="row">
                            <TextField
                                type="password"
                                hintText="Password"
                                floatingLabelText="请输入密码"  valueLink={linkState(this,'password')}
                            />
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
                <LoadingDiag open={@state.open} message={@state.message} handleDiagClose={@handleClose}/>
            </div>
        )

)

module.exports = Login
injectTapEventPlugin();

