React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

Dialog = require('material-ui/lib/dialog');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');

login = React.createClass(
    getInitialState:() ->
        open: false

    handleOpen :()  ->
        console.log("handleOpen::")
        @setState open: true
        return


    handleClose : ()  ->
        console.log("handleClose::")
        @setState open: false
        return


    render:() ->
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
        console.log("render::")
        return (
            <div>
                <RaisedButton label="Modal Dialog" onTouchTap={this.handleOpen} />
                <Dialog
                    title="Dialog With Actions"
                    actions={actions}
                    modal={false}
                    open={this.state.open}
                    onRequestClose={this.handleClose}
                >
                    Only actions can close this dialog.
                </Dialog>
            </div>
        );
)

module.exports = login
injectTapEventPlugin();
