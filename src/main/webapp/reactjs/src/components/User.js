import React, {Component} from 'react';
import {Card, Row, Col, Image} from "react-bootstrap";
import Bob from './img/Bob.png';
import axios from 'axios';

class Account extends Component {

    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    componentDidMount() {
        const userId = this.props.match.params.id;
        if (userId) {
            this.findAccountById(userId);
        }
    };

    findAccountById = (userId) => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/users/" + userId)
            .then(response => console.log(response.data))
    };

    render() {
        return (
            <div>
                <Card>
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
            </div>
        );
    }
}

export default Account;