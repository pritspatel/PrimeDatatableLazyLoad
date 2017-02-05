export class SearchCriteria{

    private name : string;
    private value : string;

    constructor() {}


    get _name(): string {
        return this.name;
    }

    set _name(value: string) {
        this.name = value;
    }

    get _value(): string {
        return this.value;
    }

    set _value(value: string) {
        this.value = value;
    }
}