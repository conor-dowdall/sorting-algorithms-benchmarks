# ###########################################
# an octave script to produce benchmark plots
# run with the command:
#       octave benchmarksPlots.m
# ###########################################

# ###############
# mean times plot
# ###############

size_mean_error_data = dlmread ("sortingAlgorithmsBenchmarks/data/data_ns.csv");

sizes = size_mean_error_data(1,:);

means_bubble = size_mean_error_data(2,:)/1000000;
errors_bubble = size_mean_error_data(3,:)/1000000;

means_selection = size_mean_error_data(4,:)/1000000;
errors_selection = size_mean_error_data(5,:)/1000000;

means_insertion = size_mean_error_data(6,:)/1000000;
errors_insertion = size_mean_error_data(7,:)/1000000;

means_quick = size_mean_error_data(8,:)/1000000;
errors_quick = size_mean_error_data(9,:)/1000000;

means_counting = size_mean_error_data(10,:)/1000000;
errors_counting = size_mean_error_data(11,:)/1000000;

f1 = figure (1);

plot = errorbar (sizes, means_bubble, errors_bubble, "~", 
                 sizes, means_selection, errors_selection, "~",
                 sizes, means_insertion, errors_insertion, "~",
                 sizes, means_quick, errors_quick, "~",
                 sizes, means_counting, errors_counting, "~");

grid on;
legend ("Bubble Sort", 
        "Selection Sort", 
        "Insertion Sort", 
        "Quicksort", 
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

# #######################
# histograms of the times
# #######################

time_data_bubble = dlmread ("sortingAlgorithmsBenchmarks/data/BubbleSortTimes.csv");
time_data_selection = dlmread ("sortingAlgorithmsBenchmarks/data/SelectionSortTimes.csv");
time_data_insertion = dlmread ("sortingAlgorithmsBenchmarks/data/InsertionSortTimes.csv");
time_data_quick = dlmread ("sortingAlgorithmsBenchmarks/data/QuicksortTimes.csv");
time_data_counting = dlmread ("sortingAlgorithmsBenchmarks/data/CountingSortTimes.csv");

f2 = figure (2, "position", [0, 0, 1500, 500]);
set (f2, "DefaultTextFontname", "Courier");

number_of_bins = 100;
x_label = "Time / ms";
y_label = "Frequency";

subplot (1, 5, 1, "align");

hist (time_data_bubble/1000000, number_of_bins);
title ("Bubble",
       "fontsize", 16);
axis ("nolabel");
xlabel (x_label,
        "fontsize", 16);
ylabel (y_label, 
        "fontsize", 16);

subplot (1, 5, 2, "align");

hist (time_data_selection/1000000, number_of_bins);
axis ("nolabel");
title ("Selection",
       "fontsize", 16);
xlabel (x_label,
        "fontsize", 16);

subplot (1, 5, 3, "align");

hist (time_data_insertion/1000000, number_of_bins);
axis ("nolabel");
title ("Insertion",
       "fontsize", 16);
xlabel (x_label,
        "fontsize", 16);

subplot (1, 5, 4, "align");

hist (time_data_quick/1000000, number_of_bins);
axis ("nolabel");
title ("Quick",
       "fontsize", 16);
xlabel (x_label,
        "fontsize", 16);

subplot (1, 5, 5, "align");

hist (time_data_counting/1000000, number_of_bins);
axis ("nolabel");
title ("Counting",
       "fontsize", 16);
xlabel (x_label,
        "fontsize", 16);

print -djpg images/time_hist.jpg;

# ################
# keep window open
# ################

pause;
