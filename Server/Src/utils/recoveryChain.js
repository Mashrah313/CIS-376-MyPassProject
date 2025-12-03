export class RecoveryChain {
    constructor(ans1, ans2, ans3) {
        this.answers = [ans1, ans2, ans3];
    }

    verify(test1, test2, test3) {
        if (test1 !== this.answers[0]) return false;
        if (test2 !== this.answers[1]) return false;
        if (test3 !== this.answers[2]) return false;
        return true;
    }
}
