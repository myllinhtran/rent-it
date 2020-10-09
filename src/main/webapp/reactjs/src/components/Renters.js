import React, {Component} from 'react';
import {Card, Form, Button, Col} from "react-bootstrap";
import {faPlusCircle, faSave} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";

class Renters extends Component {

    constructor(props) {
        super(props);
        this.state = {
            firstName: '',
            lastName: '',
            email: '',
            mobile: ''
        };
        this.renterChange = this.renterChange.bind(this);
        this.submitRenter = this.submitRenter.bind(this);
    }

    submitRenter(event) {
        alert(
            'First Name: ' + this.state.firstName +
            ', Last Name: ' + this.state.lastName +
            ', Email: ' + this.state.email +
            ', Mobile: ' + this.state.mobile
        );
        event.preventDefault();
    }

    renterChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>
                    <FontAwesomeIcon icon={faPlusCircle}/> Add New Renter
                </Card.Header>
                <Form onSubmit={this.submitRenter} id="renterFormId">
                    <Card.Body>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formFirstName">
                                <Form.Label>First Name</Form.Label>
                                <Form.Control required
                                              type="firstName" name={"firstName"}
                                              value={this.state.firstName}
                                              onChange={this.renterChange}
                                              className="bg-dark text-white"
                                              placeholder="Enter your first name"/>
                            </Form.Group>
                            <Form.Group as={Col} controlId="formEmail">
                                <Form.Label>Email</Form.Label>
                                <Form.Control required
                                              type="email" name={"email"}
                                              value={this.state.email}
                                              onChange={this.renterChange}
                                              className="bg-dark text-white"
                                              placeholder="Enter your email"/>
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col} controlId="formLastName">
                                <Form.Label>Last Name</Form.Label>
                                <Form.Control required
                                              type="lastName" name={"lastName"}
                                              value={this.state.lastName}
                                              onChange={this.renterChange}
                                              className="bg-dark text-white"
                                              placeholder="Enter your last name"/>
                            </Form.Group>
                            <Form.Group as={Col} controlId="formMobile">
                                <Form.Label>Mobile</Form.Label>
                                <Form.Control required
                                              type="mobile" name={"mobile"}
                                              value={this.state.mobile}
                                              onChange={this.renterChange}
                                              className="bg-dark text-white"
                                              placeholder="Enter your mobile"/>
                            </Form.Group>
                        </Form.Row>
                    </Card.Body>
                    <Card.Footer style={{"text-align": "right"}}>
                        <Button size="sm" variant="success" type="submit">
                            <FontAwesomeIcon icon={faSave}/> Submit
                        </Button>
                    </Card.Footer>
                </Form>
            </Card>
        )
    }
}

export default Renters;