import React, {Component} from 'react';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {Card, Form, Button, Col} from "react-bootstrap";
import {faList, faPlusSquare, faSave, faUndo} from "@fortawesome/free-solid-svg-icons";
import axios from 'axios';
import MyToast from "./MyToast";

class Renters extends Component {

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.state.show = false;
        this.resetRenter = this.resetRenter.bind(this);
        this.submitRenter = this.submitRenter.bind(this);
    };

    initialState = {
        id: '',
        firstName: '',
        lastName: '',
        email: '',
        mobile: ''
    };

    componentDidMount() {
        const renterId = this.props.match.params.id;
        if (renterId) {
            this.findRenterById(renterId);
        }
    };

    findRenterById = (renterId) => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/renters/" + renterId)
            .then(response => {
                if (response.data != null) {
                    this.setState({
                        id: response.data.id,
                        firstName: response.data.firstName,
                        lastName: response.data.lastName,
                        email: response.data.email,
                        mobile: response.data.mobile
                    });
                }
            }).catch((error) => {
            console.error("Error - " + error);
        });
    };

    resetRenter = () => {
        this.setState(() => this.initialState);
    };

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
                    this.setState({"show": true});
                    setTimeout(() => this.setState({"show": false}), 3000);
                } else {
                    this.setState({"show": false});
                }
            });

        this.setState(this.initialState);
    };

    updateRenter = event => {

        event.preventDefault();

        const renter = {
            id: this.state.id,
            firstName: this.state.firstName,
            lastName: this.state.lastName,
            email: this.state.email,
            mobile: this.state.mobile
        };

        axios.put("https://safe-sierra-04090.herokuapp.com/api/v1/renters/", renter)
            .then(response => {
                if (response.data != null) {
                    this.setState({"show": true});
                    setTimeout(() => this.setState({"show": false}), 3000);
                    setTimeout(() => this.renterList(), 1000);
                } else {
                    this.setState({"show": false});
                }
            });
    };


    renterChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    renterList = () => {
        return this.props.history.push("/renters");
    };

    render() {

        const {firstName, lastName, email, mobile} = this.state;

        return (

            <div>
                <div style={{"display": this.state.show ? "block" : "none"}}>
                    <MyToast show={this.state.show}
                             message={this.state.id ? "Renter Updated Successfully." : "Renter Saved Successfully."}
                             type={"success"}/>
                </div>
                <Card className={"border border-dark bg-dark text-white"}>
                    <Card.Header>
                        <FontAwesomeIcon
                            icon={this.state.id ? faSave : faPlusSquare}/> {this.state.id ? "Update Renter" : "Add New Renter"}
                    </Card.Header>
                    <Form onReset={this.resetRenter} onSubmit={this.state.id ? this.updateRenter : this.submitRenter}
                          id="renterFormId">
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
                                <FontAwesomeIcon icon={faSave}/> {this.state.id ? "Update" : "Save"}
                            </Button>{' '}
                            <Button size="sm" variant="info" type="reset">
                                <FontAwesomeIcon icon={faUndo}/> Reset
                            </Button>{' '}
                            <Button size="sm" variant="info" type="button" onClick={this.renterList.bind()}>
                                <FontAwesomeIcon icon={faList}/> Renter List
                            </Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>
        )
    }
}

export default Renters;