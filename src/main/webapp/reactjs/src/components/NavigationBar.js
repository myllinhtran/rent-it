import React, {Component} from 'react';
import {Navbar, Nav} from 'react-bootstrap';
import {Link} from 'react-router-dom';
import './css/NavigationBar.css';

class NavigationBar extends Component {

    render() {
        return (
            <Navbar bg="dark" variant="dark">
                <Link to="" className="navbar-brand">R E N T I T</Link>
                <Nav className="mr-auto">
                    <Link to="renters" className="nav-link">Renter</Link>
                    <Link to="signup" className="nav-link">Signup</Link>
                    <Link to="login" className="nav-link">Login</Link>
                </Nav>
            </Navbar>
        );
    }
}

export default NavigationBar;