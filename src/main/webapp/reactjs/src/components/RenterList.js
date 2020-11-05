import React, {Component} from 'react';
import axios from 'axios';
import {Button, ButtonGroup, Card, Table} from "react-bootstrap";
import {faEdit, faList, faTrash} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import MyToast from "./MyToast";
import {Link} from "react-router-dom";


class RenterList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            renters: []
        };

        this.getRenters = this.getRenters.bind(this);
        this.deleteRenter = this.deleteRenter.bind(this);
    };

    componentDidMount() {
        this.getRenters();
    };

    getRenters() {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/accounts")
            .then(response => response.data)
            .then((data) => {
                this.setState({renters: data});
            });
    };

    deleteRenter = (renterId) => {
        axios.delete("https://safe-sierra-04090.herokuapp.com/api/v1/accounts/" + renterId)
            .then(response => {
                if (response != null) {
                    this.setState({"show": true});
                    setTimeout(() => this.setState({"show": false}), 3000);
                    this.setState({
                        renters: this.state.renters.filter(renter => renter.id !== renterId)
                    })
                } else {
                    this.setState({"show": false});
                }
            });
    };

    render() {
        return (
            <div style={{margin: "20px 60px 80px 60px"}}>
                <div style={{"display": this.state.show ? "block" : "none"}}>
                    <MyToast show={this.state.show} message={"Renter Deleted Successfully."} type={"danger"}/>
                </div>
                <Card className={"border border-grey bg-light text-dark"}>
                    <Card.Header>
                        <FontAwesomeIcon icon={faList}/> Renter List
                    </Card.Header>
                    <Card.Body>
                        <Table bordered hover striped>
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
                                                    <Link to={"/renters/edit/" + renter.id}
                                                          className="btn btn-sm btn-outline-primary"><FontAwesomeIcon
                                                        icon={faEdit}/>
                                                    </Link>{' '}
                                                    <Button onClick={this.deleteRenter.bind(this, renter.id)}
                                                            size={"sm"}
                                                            variant={"danger"}><FontAwesomeIcon
                                                        icon={faTrash}/></Button>
                                                </ButtonGroup>
                                            </td>
                                        </tr>
                                    ))}
                            </tbody>
                        </Table>
                    </Card.Body>
                </Card>
            </div>
        );
    }
}

export default RenterList;