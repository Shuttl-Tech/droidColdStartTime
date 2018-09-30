#!/usr/bin/env bash

#trim empty spaces in original file

#clear output processed
true > output_PROCESSED.txt

file="output_RAW.txt"
sed -i -e "/^$/d" $file

while IFS= read -r line
do

    if [[ $line = *"SplashScreen"* ]]; then
    echo "-------------------" | tee -a output_PROCESSED.txt
    echo "SplashScreen:" | tee -a output_PROCESSED.txt
    echo "$line" | sed 's/.*+//' | tee -a output_PROCESSED.txt
    fi

	if [[ $line = *"BookingActivity"* ]]; then
    echo "BookingActivity:" | tee -a output_PROCESSED.txt
    echo "$line" | sed 's/.*+//' | tee -a output_PROCESSED.txt
    echo "-------------------" | tee -a output_PROCESSED.txt
    fi

done <"$file"