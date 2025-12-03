class PasswordBuilder {
    constructor() {
        this.length = 12;
        this.upper = false;
        this.lower = false;
        this.numbers = false;
        this.symbols = false;
    }

    setLength(len) { this.length = len; return this; }
    includeUpper() { this.upper = true; return this; }
    includeLower() { this.lower = true; return this; }
    includeNumbers() { this.numbers = true; return this; }
    includeSymbols() { this.symbols = true; return this; }

    build() {
        let chars = "";
        if (this.upper) chars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (this.lower) chars += "abcdefghijklmnopqrstuvwxyz";
        if (this.numbers) chars += "0123456789";
        if (this.symbols) chars += "@#$&*%-_+";

        let pass = "";
        for (let i = 0; i < this.length; i++) {
            pass += chars.charAt(Math.floor(Math.random() * chars.length));
        }
        return pass;
    }
}

export default PasswordBuilder;
