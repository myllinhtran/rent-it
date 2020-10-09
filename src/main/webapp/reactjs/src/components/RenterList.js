import React, {Component} from 'react';
import axios from 'axios';
import {Card} from "react-bootstrap";
import {faList} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";


class RenterList extends Component {

    constructor(props) {
        super(props);
        this.state = {
            renters: []
        };
    }

    componentDidMount() {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/renters")
            .then(response => console.log(response.data));
    }

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>
                    <FontAwesomeIcon icon={faList}/> Renter List
                </Card.Header>
                <Card.Body>
                    <Card.Title>Renter's Name</Card.Title>
                    <Card.Text>
                        Brief information about renters and their offered products for rent.
                    </Card.Text>
                    <Card.Link href="#">See more</Card.Link>
                </Card.Body>
            </Card>
        );
    }
}

export default RenterList;