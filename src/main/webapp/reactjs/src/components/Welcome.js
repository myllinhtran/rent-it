import React, {Component} from 'react';
import {Jumbotron} from "react-bootstrap";

class Welcome extends Component {
    render() {
        return (
            <Jumbotron className="bg-dark text-white">
                <h1>Welcome to Rentit</h1>
                <blockquote className="blockquote mb-0">
                    <p>
                        Forget the map, roll down the windows, and whenever you can, pull over and have a picnic.
                    </p>
                    <footer className="blockquote-footer">
                        Jim Hensen
                    </footer>
                </blockquote>
            </Jumbotron>
        );
    }
}

export default Welcome;