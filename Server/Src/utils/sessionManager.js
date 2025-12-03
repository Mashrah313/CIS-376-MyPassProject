class SessionManager {
    constructor() {
        if (!SessionManager.instance) {
            this.userId = null;
            SessionManager.instance = this;
        }
        return SessionManager.instance;
    }

    setUser(id) {
        this.userId = id;
    }

    getUser() {
        return this.userId;
    }
}

const instance = new SessionManager();
export default instance;
