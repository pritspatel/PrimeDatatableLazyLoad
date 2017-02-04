export class Filter{

    private fieldName : string;
    private fieldValue : string;
    constructor(){}

    get _fieldName(): string {
        return this.fieldName;
    }

    set _fieldName(value: string) {
        this.fieldName = value;
    }

    get _fieldValue(): string {
        return this.fieldValue;
    }

    set _fieldValue(value: string) {
        this.fieldValue = value;
    }
}