package com.uuu.demo1.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Form1 {
    private boolean[] conditions = {true, true, false, false, true, false};
    private String[] names = {"C#","Java","Solidity","Solana","NodeJS","Kotlin"};
}