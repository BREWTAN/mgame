React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

Loader = require('halogen/RingLoader');
Paper = require( 'material-ui/lib/paper');

Loading = React.createClass(

    contextTypes: {
        router: React.PropTypes.object
    },

    getInitialState:() ->
        open: false


    render:() ->
        console.log("render::loading")
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
                height: '200px',
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

        return (
            <div style={pstyle} className="container">
                <div style={style} zDepth={1}>
                    <Loader color="#26A65B" margin="20px"/>
                </div>
            </div>

        )

)

module.exports = Loading

