import React, {Component} from 'react';


class RentedProducts extends Component {

    render() {

        const {id, category } = this.props;

        return (
            <tr key={id}>
                <td>{id}</td>
                <td>{category}</td>
            </tr>
        )
    }
}

export default RentedProducts;