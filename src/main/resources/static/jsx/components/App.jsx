import React from 'react';
import {Post} from './Post.jsx';
import {Navigation} from './Navigation.jsx';

export class App extends React.Component {
  render() {
		var userNodes = this.props.data.posts.map(function (post) {
			return (
				<Post key={post.id} text={post.text}/>
			);
		});
		
        return (
	        <div className="container">
				<Navigation/>
				<div className="panel panel-default">
  					<div className="panel-heading">Brand new posts <span className="badge">{this.props.data.posts.length}</span></div>
  					<div className="panel-body">
				       <div className="row">{userNodes}</div>
  					</div>
				</div>
			</div>
		);
    }
}