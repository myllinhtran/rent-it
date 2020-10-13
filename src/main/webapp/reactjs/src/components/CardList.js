import React, {Component} from 'react';
import axios from 'axios';
import {Table, Card, ButtonGroup, Button} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList, faEdit, faTrash} from "@fortawesome/free-solid-svg-icons";

class CardList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            renters: []
        };

        this.getRenters = this.getRenters.bind(this);
    }

    componentDidMount() {
        this.getRenters();
    }

    getRenters() {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/renters")
            .then(response => response.data)
            .then((data) => {
                this.setState({renters: data});
            });
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>
                    <FontAwesomeIcon icon={faList}/> Renter List
                </Card.Header>
                <Card.Body>
                    <Table bordered hover striped variant="dark">
                        <thead>
                        <tr align="center">
                            <th>#</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Mobile</th>
                            <th>Action</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.renters.length === 0 ?
                                <tr align="center">
                                    <td colSpan="6">{this.state.renters.length} Renters Available.</td>
                                </tr> :
                                this.state.renters.map((renter) => (
                                    <tr key={renter.id}>
                                        <td align={"center"}>{renter.id}</td>
                                        <td>{renter.firstName} {renter.lastName}</td>
                                        <td>{renter.email}</td>
                                        <td>{renter.mobile}</td>
                                        <td align={"center"}>
                                            <ButtonGroup>
                                                <Button size={"sm"} variant={"primary"}><FontAwesomeIcon icon={faEdit}/></Button>{' '}
                                                <Button size={"sm"} variant={"danger"}><FontAwesomeIcon icon={faTrash}/></Button>{' '}
                                            </ButtonGroup>
                                        </td>
                                    </tr>
                                ))
                        }
                        </tbody>
                    </Table>
                </Card.Body>
            </Card>
        );
    }
}

export default CardList;