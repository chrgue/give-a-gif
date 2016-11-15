import React from 'react';

export class Post extends React.Component {
	render() {
		var postImageUrl = 'http://lorempixel.com/400/200/sports/?q=' + (new Date()).getTime();
        return (
			<div className="col-sm-6 col-md-4">
				<div className="thumbnail">
					<img src={postImageUrl}/>
					<div className="caption">
						<h3>Thumbnail label</h3>
						<p>{this.props.text}</p>
						<p><a href="#" className="btn btn-primary" role="button">Button</a> <a href="#" className="btn btn-default" role="button">Button</a></p>
					</div>
				</div>
			</div>	
		);
    }
}