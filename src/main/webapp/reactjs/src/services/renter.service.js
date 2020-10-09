import http from "../http-common";


class RenterService {
    
    getAll() {
        return http.get(`/renters`);
    }

    get(id) {
        return http.get(`/renters/${id}`);
    }

    create(data) {
        return http.post(`/renters`, data);
    }

    update(id, data) {
        return http.put(`/renters/${id}`, data);
    }

    delete(id) {
        return http.delete(`/renters/${id}`);
    }

    deleteAll() {
        return http.deleteAll(`/renters`);
    }

    findByFirstName(firstName) {
        return http.get(`/renters?firstName=${firstName}`);
    }

}

export default RenterService;