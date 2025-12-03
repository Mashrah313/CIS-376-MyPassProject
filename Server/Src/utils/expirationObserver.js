export class ExpirationNotifier {
    static notify(type, value) {
        if (type === "Credit Card" && value && value.length >= 4) {
            console.log("Credit card expiration check triggered.");
        }
    }
}
