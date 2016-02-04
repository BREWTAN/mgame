React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

Loader = require('halogen/RingLoader');

Dialog = require( 'material-ui/lib/dialog');
FlatButton = require( 'material-ui/lib/flat-button');
RaisedButton = require( 'material-ui/lib/raised-button');

LoadingDiag = React.createClass(

    contextTypes: {
        router: React.PropTypes.object
    },


    getInitialState:() ->
        open: false


    handleOpen : () ->
        @props.open=true;


    handleClose : () ->
        console.log("close:")
        @props.handleDiagClose()




    render:() ->
        console.log("render::loading:open="+@state.open+",props="+@props.open)
        style = {
                display: '-webkit-flex',
                display: 'flex',
                webkitFlex: '0 1 auto',
                flex: '0 1 auto',
                webkitFlexDirection: 'column',
                flexDirection: 'column',
                webkitFlexGrow: 1,
                flexGrow: 1,
                webkitFlexShrink: 0,
                flexShrink: 0,
                webkitFlexBasis: '25%',
                flexBasis: '25%',
                maxWidth: '25%',
                webkitAlignItems: 'center',
                alignItems: 'center',
                webkitJustifyContent: 'center',
                justifyContent: 'center'
            };
        pstyle={
            height: '100%',
            width: '100%',
            margin: 0,
            justifyContent: 'center'
            boxSizing: 'border-box',
            display: '-webkit-flex',
            display: 'flex',
            webkitFlex: '0 1 auto',
            flex: '0 1 auto',
            webkitFlexDirection: 'row',
            flexDirection: 'row',
            webkitFlexWrap: 'wrap',
            flexWrap: 'wrap'
        }

        if @props.message == ''
            child = <div style={pstyle} >
               <div style={style} zDepth={1}>
                    <Loader color="#26A65B" margin="20px"/>
                </div>
            </div>
            actions= []

        else
            child =　''
            actions =[
                       <FlatButton
                            label="确定"
                            primary={true}
                            onTouchTap={this.handleClose}
                          />
                    ]
        console.log("message="+@props.message+",child="+child)

        return (
            <div className="container-fluid">
                <Dialog
                  modal={true}
                  actions={actions}
                  open={@props.open}
                  title={@props.message}
                >
                    {child}
                </Dialog>
            </div>

        )

)

module.exports = LoadingDiag

