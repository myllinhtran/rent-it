import React, {Component} from 'react';
import home_img from "./img/home_img.png";
import {Breadcrumb} from 'react-bootstrap';

class About extends Component {

    render() {
        return (
            <div>
                <Breadcrumb>
                    <Breadcrumb.Item href="/" >Home</Breadcrumb.Item>
                    <Breadcrumb.Item active href="about">About</Breadcrumb.Item>
                </Breadcrumb>
                <h2><img src={home_img} alt="home_img" width="350px"/></h2>
            </div>
        )
    }
}

export default About;