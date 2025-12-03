class MaskProxy {
    static mask(text) {
        // Don't mask on storage - store the actual value
        // Frontend will handle display masking with show/hide toggles
        return text;
    }

    static unmask(original) {
        return original;
    }

    static displayMask(text) {
        // Use this only for display purposes
        if (!text) return '';
        return '*'.repeat(Math.min(text.length, 8));
    }
}

export default MaskProxy;
