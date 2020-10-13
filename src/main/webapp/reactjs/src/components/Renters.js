import React, {Component} from 'react';
import {Card, Form, Button, Col} from "react-bootstrap";
import {faPlusCircle, faSave, faUndo} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import axios from 'axios';
import MyToast from "./MyToast";

class Renters extends Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.state.show = false;
        this.resetRenter = this.resetRenter.bind(this);
        this.submitRenter = this.submitRenter.bind(this);
    }

    initialState = {
        firstName: '',
        lastName: '',
        email: '',
        mobile: ''
    }

    resetRenter = () => {
        this.setState(() => this.initialState);
    }

    submitRenter = event => {
        event.preventDefault();

        const renter = {
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            mobile: this.state.mobile
        };

        axios.post("https://safe-sierra-04090.herokuapp.com/api/v1/renters", renter)
            .then(response => {
                if (response.data != null) {
                    this.setState(this.initialState);
                    alert("Renter Saved Successfully");
                }
            });
    }

    renterChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    render() {

        const {firstName, lastName, email, mobile} = this.state;

        return (

            <div>
                <div style={{"display": this.state.show ? "block" : "none"}}>
                    <MyToast children={{show: this.state.show, message: "Renter Saved Successfully."}}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header>
                        <FontAwesomeIcon icon={faPlusCircle}/> Add New Renter
                    </Card.Header>
                    <Form onReset={this.resetRenter} onSubmit={this.submitRenter} id="renterFormId">
                        <Card.Body>
                            <Form.Row>
                                <Form.Group as={Col} controlId="formFirstName">
                                    <Form.Label>First Name</Form.Label>
                                    <Form.Control required
                                                  type="firstName" name={"firstName"}
                                                  value={firstName} onChange={this.renterChange}
                                                  className="bg-dark text-white"
                                                  placeholder="Enter your first name"/>
                                </Form.Group>
                                <Form.Group as={Col} controlId="formEmail">
                                    <Form.Label>Email</Form.Label>
                                    <Form.Control required
                                                  type="email" name={"email"}
                                                  value={email} onChange={this.renterChange}
                                                  className="bg-dark text-white"
                                                  placeholder="Enter your email"/>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col} controlId="formLastName">
                                    <Form.Label>Last Name</Form.Label>
                                    <Form.Control required
                                                  type="lastName" name={"lastName"}
                                                  value={lastName} onChange={this.renterChange}
                                                  className="bg-dark text-white"
                                                  placeholder="Enter your last name"/>
                                </Form.Group>
                                <Form.Group as={Col} controlId="formMobile">
                                    <Form.Label>Mobile</Form.Label>
                                    <Form.Control required
                                                  type="mobile" name={"mobile"}
                                                  value={mobile} onChange={this.renterChange}
                                                  className="bg-dark text-white"
                                                  placeholder="Enter your mobile"/>
                                </Form.Group>
                            </Form.Row>
                        </Card.Body>
                        <Card.Footer style={{"text-align": "right"}}>
                            <Button size="sm" variant="success" type="submit">
                                <FontAwesomeIcon icon={faSave}/> Submit
                            </Button>{' '}
                            <Button size="sm" variant="info" type="reset">
                                <FontAwesomeIcon icon={faUndo}/> Reset
                            </Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>
        )
    }
}

export default Renters;