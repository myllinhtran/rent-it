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
                    <Link to="renters" className="nav-link">Renters</Link>
                    <Link to="products" className="nav-link">Products</Link>
                    <Link to="profile" className="nav-link">My Profile</Link>
                </Nav>
            </Navbar>
        );
    }
}

export default NavigationBar;