import React, {Component} from 'react';
import NavBar from 'react-bootstrap/Navbar';
import Container from "react-bootstrap/Container";
import Col from "react-bootstrap/Col";

class Footer extends Component {
    render() {
        let fullYear = new Date().getFullYear();

        return (
            <NavBar fixed="bottom" bg="dark" varian="dark">
                <Container>
                    <Col lg={12} className="text-center text-muted">
                        <div>{fullYear}-{fullYear+1}, All Rights Reserved by Linh Tran</div>
                    </Col>
                </Container>
            </NavBar>
        );
    }
}

export default Footer;