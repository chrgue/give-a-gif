import React from 'react';
import {Post} from './Post.jsx';
import {Navigation} from './Navigation.jsx';

export class App extends React.Component {
  render() {
		var userNodes = this.props.users.map(function (user, index) {
			return (
				<Post userId={user}/>
			);
		});
		
        return (
	        <div className="container">
				<Navigation/>
				<div className="panel panel-default">
  					<div className="panel-heading">Brand new posts<span className="badge">{this.props.users.length}</span></div>
  					<div className="panel-body">
				       <div className="row">{userNodes}</div>
  					</div>
				</div>
			</div>
		);
    }
}