import React, {Component} from 'react';
import Card from "react-bootstrap/Card";

class Categories extends Component {

    render() {
        return (
            <Card className={"border border-dark bg-dark text-white"}>
                <Card.Header>Categories List</Card.Header>
                <Card.Body>
                    <Card.Title>Category</Card.Title>
                    <Card.Text>
                        Brief information about the categories.
                    </Card.Text>
                    <Card.Link href="#">See more</Card.Link>
                </Card.Body>
            </Card>
        )
    }
}

export default Categories;