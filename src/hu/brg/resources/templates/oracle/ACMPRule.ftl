-- Attribute Compare Rule :: ${column1} ${value} ${operand}
    BEGIN
        IF l_oper IN ('INS', 'UPD')
        THEN
            IF :new.${column1} ${operand} ${value}
            THEN 
                l_errors := l_errors || 'The value of ${column1} must be ${operand} ${value}';
            END IF;
        END IF;
    END;