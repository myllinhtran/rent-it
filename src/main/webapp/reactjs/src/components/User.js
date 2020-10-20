import React, {Component} from 'react';
import {Card, Row, Col, Image} from "react-bootstrap";
import Bob from './img/Bob.png';

class User extends Component {

    render() {

        const {id, firstName, lastName, email, mobile} = this.props;

        return (
            <div>
                <Card style={{margin: "0 0 20px 0"}}>
                    <Card.Header>ID [{id}]</Card.Header>
                    <Card.Body>
                        <Row>
                            <Col>
                                <Card.Title>{firstName} {lastName}</Card.Title>
                                <ul>
                                    <li>{mobile}</li>
                                    <li>{email}</li>
                                </ul>
                            </Col>
                            <Col xs={4} align={"right"}>
                                <Image src={Bob} rounded={"10px"} style={{width: "50%"}}/>
                            </Col>
                        </Row>
                    </Card.Body>
                </Card>
            </div>
        );
    }
}

export default User;