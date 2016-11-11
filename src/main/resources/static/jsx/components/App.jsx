var App = React.createClass({
	
	render: function () {
		var userNodes = this.props.users.map(function (user, index) {
			return <h1>{user}</h1>;
		});
		
        return (
        	<div>{userNodes}</div>
        );
    }
});