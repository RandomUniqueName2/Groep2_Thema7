-- Inter-Entity Compare Rule :: ${column1} ${table} ${column2} ${operand} ${key1} ${key2}
    DECLARE
    l_number   number;
    BEGIN
        IF l_oper IN ('INS', 'UPD')
        THEN
            SELECT ${column2} into l_number FROM ${table} WHERE ${key1} = ${key2};
            IF :new.${column1} ${operand} l_number
            THEN 
                l_errors := l_errors || 'The value of ${column1} must be ${operand} ${table}.${column2}';
            END IF;
        END IF;
    END;