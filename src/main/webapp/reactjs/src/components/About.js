import React, {Component} from 'react';
import home_img from "./img/home_img.png";

class About extends Component {

    render() {
        return (
            <div>
                <h2><img src={home_img} alt="home_img" width="350px"/></h2>
            </div>
        )
    }
}

export default About;