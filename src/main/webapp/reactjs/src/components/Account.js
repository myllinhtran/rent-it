import React, {Component} from 'react';
import {Card, Row, Col, Image} from "react-bootstrap";
import Bob from './img/Bob.png';

class Account extends Component {

    render() {
        return (
            <Card >
                <Card.Header>Header</Card.Header>
                <Card.Body>
                    <Row>
                        <Col>
                            <Card.Title>Rentee Name</Card.Title>
                            <Card.Text>Rentee Personal Information</Card.Text>
                        </Col>
                        <Col xs={4} align={"right"}>
                            <Image src={Bob} rounded={"10px"} style={{width: "50%"}}/>
                        </Col>
                    </Row>
                </Card.Body>
            </Card>
        );
    }
}

export default Account;