// map is a datastructure that allows us to store key-value pairs
//@field
Map defaults = [
    dice: [
        // my-workspace: "${WORKSPACE}",
        myParam1: 'test1',
        myParam2: 'test2',
        myParam3: 'test3',
        myParam4: 'test4',
        myParam5: 'test5',
    ]
];

Map m2 = [
    mice: [
        myParam1: "boofarts",
    ]
];

merged_map = defaults + m2

print(merged_map)

def call(Map cfg) {
    // cfg = defaults + cfg
    print(cfg.dice.myParam1)
    print(cfg.dice.my-workspace)

}

// println(defaults.dice.myParam5)
call(defaults)