# ###########################################
# an octave script to produce benchmark plots
# run with the command:
#       octave benchmarksPlots_alt.m
# ###########################################

# ###############
# mean times plot - just quick and counting
# ###############

size_mean_error_data = dlmread ("sortingAlgorithmsBenchmarks/data/data_ns.csv");

sizes = size_mean_error_data(1,:);

means_quick = size_mean_error_data(8,:)/1000000;
errors_quick = size_mean_error_data(9,:)/1000000;

means_counting = size_mean_error_data(10,:)/1000000;
errors_counting = size_mean_error_data(11,:)/1000000;

f1 = figure (1);

plot = errorbar (sizes, means_quick, errors_quick, "~",
                 sizes, means_counting, errors_counting, "~");

grid on;
legend ("Quicksort", 
        "Counting Sort", 
        "location", "northwest",
        "fontsize", 12);
title ("Sorting Algorithm Benchmarks", 
       "fontsize", 20);
xlabel ("Input Array Size", 
        "fontsize", 13);
ylabel ("Mean Time To Sort Array / ms",
        "fontsize", 13);
set (plot, 
     "linewidth", 2);

print -djpg images/time_plot.jpg;

# ################
# keep window open
# ################

pause;
