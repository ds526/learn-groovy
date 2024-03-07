// map is a datastructure that allows us to store key-value pairs
//@field
Map defaults = [
    dice: [
        myParam1: 'test1',
        myParam2: 'test2',
        myParam3: 'test3',
        myParam4: 'test4',
        myParam5: 'test5',
    ]
];

def call(Map cfg) {
    // cfg = defaults + cfg
    print(cfg.dice.myParam1)

}

// println(defaults.dice.myParam5)
call(defaults)