
var UserBox = React.createClass({
    
	render: function () {
		
		var userNodes = this.props.users.map(function (user, index) {
			return React.createElement("h1", null, user);
		});
            
        return (
            React.createElement("div", {className: "usersBox"}, userNodes)
        );
    }
});